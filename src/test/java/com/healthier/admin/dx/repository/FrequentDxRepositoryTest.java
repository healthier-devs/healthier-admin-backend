package com.healthier.admin.dx.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.healthier.admin.domain.mongo.dx.domain.frequentDx.FrequentDx;
import com.healthier.admin.domain.mongo.dx.repository.FrequentDxRepository;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

@DataMongoTest
public class FrequentDxRepositoryTest {

    @Autowired private FrequentDxRepository frequentDxRepository;

    @Test
    public void saveFrequentDxTest() {
        // Given
        FrequentDx frequentDx =
                FrequentDx.builder()
                        .name("급성 기관지염")
                        .ageGroups(Arrays.asList(1, 2, 3))
                        .image("image url")
                        .build();

        // When
        FrequentDx savedFrequentDx = frequentDxRepository.save(frequentDx);

        // Then
        assertThat(savedFrequentDx.getId()).isNotNull();
        assertThat(savedFrequentDx.getName()).isEqualTo("급성 기관지염");
        assertThat(savedFrequentDx.getAgeGroups()).containsExactly(1, 2, 3);

        frequentDxRepository.delete(savedFrequentDx);
    }
}
