package ir.maktab.homeserviceprovider.service;

import ir.maktab.homeserviceprovider.entity.Expert;
import ir.maktab.homeserviceprovider.repository.ExpertRepository;
import org.springframework.stereotype.Service;

@Service
public class ExpertService extends UserService<Expert> {

    private final ExpertRepository repository;

    public ExpertService(ExpertRepository expertRepository) {
        super(expertRepository);
        this.repository = expertRepository;
    }
}
