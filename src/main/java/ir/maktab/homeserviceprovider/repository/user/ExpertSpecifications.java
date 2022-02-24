package ir.maktab.homeserviceprovider.repository.user;

import ir.maktab.homeserviceprovider.domain.model.service.ServiceModel;
import ir.maktab.homeserviceprovider.domain.model.user.ExpertModel;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class ExpertSpecifications extends UserSpecifications<ExpertModel> {

    public Specification<ExpertModel> withService(ServiceModel service) {
        if (service == null) {
            return null;
        }
        //TODO check this correct or nou
        return (root, query, builder) -> builder.in(root.get("expertServices").get("service")).value(service);
    }

}
