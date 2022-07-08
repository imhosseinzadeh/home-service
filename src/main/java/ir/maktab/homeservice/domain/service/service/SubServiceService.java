package ir.maktab.homeservice.domain.service.service;

import ir.maktab.homeservice.domain.model.service.SubServiceModel;
import ir.maktab.homeservice.domain.service.BaseService;
import ir.maktab.homeservice.dto.service.SubServiceDto;
import ir.maktab.homeservice.mapper.service.SubServiceMapper;
import ir.maktab.homeservice.repository.service.SubServiceRepository;
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
