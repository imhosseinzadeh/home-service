package ir.maktab.homeserviceprovider.service;

import ir.maktab.homeserviceprovider.entity.Expert;
import ir.maktab.homeserviceprovider.repository.ExpertRepository;
import org.springframework.stereotype.Service;

@Service
public class ExpertService extends BaseService<Expert, Long> {

    private final ExpertRepository expertRepository;

    public ExpertService(ExpertRepository expertRepository) {
        super(expertRepository);
        this.expertRepository = expertRepository;
    }
}
