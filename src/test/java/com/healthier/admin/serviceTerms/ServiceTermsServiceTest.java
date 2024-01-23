package com.healthier.admin.serviceTerms;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.healthier.admin.domain.serviceTerms.domain.ServiceTerms;
import com.healthier.admin.domain.serviceTerms.domain.TermsType;
import com.healthier.admin.domain.serviceTerms.dto.ServiceTermsDto;
import com.healthier.admin.domain.serviceTerms.repository.ServiceTermsRepository;
import com.healthier.admin.domain.serviceTerms.service.ServiceTermsService;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ServiceTermsServiceTest {

    @Mock private ServiceTermsRepository serviceTermsRepository;

    @InjectMocks private ServiceTermsService serviceTermsService;

    private ServiceTerms term1, term2;
    private ServiceTermsDto termsDto1, termsDto2;

    @BeforeEach
    void setUp() {
        term1 =
                ServiceTerms.builder()
                        .id(1L)
                        .type(TermsType.TERMS_OF_USE)
                        .content("서비스 이용약관")
                        .build();

        term2 =
                ServiceTerms.builder()
                        .id(2L)
                        .type(TermsType.PRIVACY_POLICY)
                        .content("개인정보 처리방침")
                        .build();

        termsDto1 = ServiceTermsDto.builder().type("TERMS_OF_USE").content("서비스 이용약관").build();

        termsDto2 = ServiceTermsDto.builder().type("PRIVACY_POLICY").content("개인정보 처리방침").build();
    }

    @DisplayName("서비스 약관 전체 조회")
    @Test
    void getAllServiceTermsTest() {
        // Given
        when(serviceTermsRepository.findAll()).thenReturn(Arrays.asList(term1, term2));

        // When
        List<ServiceTermsDto> result = serviceTermsService.getAllServiceTerms();

        // Then
        assertEquals(2, result.size());

        assertTrue(result.stream().anyMatch(dto -> dto.getId().equals(term1.getId())));
        assertTrue(result.stream().anyMatch(dto -> dto.getId().equals(term2.getId())));
    }

    @DisplayName("서비스 약관 개별 조회")
    @Test
    void getServiceTermsTest() {
        // Given
        Long id = 1L;
        when(serviceTermsRepository.findById(id)).thenReturn(Optional.of(term1));

        // When
        ServiceTermsDto result = serviceTermsService.getServiceTerms(id);

        // Then
        assertNotNull(result);
        assertEquals(term1.getId(), result.getId());
        assertEquals(term1.getContent(), result.getContent());
    }

    @DisplayName("서비스 약관 수정")
    @Test
    void updateServiceTermsTest() {
        // Given
        Long id = 1L;
        when(serviceTermsRepository.findById(id)).thenReturn(Optional.of(term1));

        // When
        serviceTermsService.updateServiceTerms(id, termsDto1);

        // Then
        verify(serviceTermsRepository).save(term1);
    }
}
