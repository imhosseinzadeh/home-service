package ir.maktab.homeserviceprovider.repository;

import ir.maktab.homeserviceprovider.entity.Expert;

import org.springframework.stereotype.Repository;

@Repository
public interface ExpertRepository extends UserRepository<Expert> {
}