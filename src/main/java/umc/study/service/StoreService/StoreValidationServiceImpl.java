package umc.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.repository.StoreRepository;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreValidationServiceImpl implements StoreValidationService{
    private StoreRepository storeRepository;
    @Override
    public boolean StoreExistById(Long storeId) {
        return storeRepository.existsById(storeId);
    }
}
