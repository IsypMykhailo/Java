package com.itstep.firstspring.repos.portfolio;

import com.itstep.firstspring.entities.portfolio.PortfolioCategory;
import org.springframework.data.repository.CrudRepository;

public interface PortfolioCategoryRepository extends CrudRepository<PortfolioCategory, Long> {
}
