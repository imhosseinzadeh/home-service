package ir.maktab.homeserviceprovider.domain.service.service;

import ir.maktab.homeserviceprovider.domain.model.service.SubServiceModel;
import ir.maktab.homeserviceprovider.domain.service.BaseService;
import ir.maktab.homeserviceprovider.dto.service.SubServiceDto;
import ir.maktab.homeserviceprovider.mapper.service.SubServiceMapper;
import ir.maktab.homeserviceprovider.repository.service.SubServiceRepository;
import org.springframework.stereotype.Service;

@Service
public class SubServiceService extends BaseService<SubServiceModel, SubServiceDto, Long> {

    private final SubServiceRepository repository;
    private final SubServiceMapper subServiceMapper;

    public SubServiceService(SubServiceRepository repository, SubServiceMapper subServiceMapper) {
        super(repository, subServiceMapper);
        this.repository = repository;
        this.subServiceMapper = subServiceMapper;
    }

}
