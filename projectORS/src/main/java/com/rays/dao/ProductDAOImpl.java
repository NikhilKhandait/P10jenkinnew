package com.rays.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.ProductDTO;

@Repository
public class ProductDAOImpl extends BaseDAOImpl<ProductDTO> implements ProductDAOInt {

	@Override
	protected List<Predicate> getWhereClause(ProductDTO dto, CriteriaBuilder builder, Root<ProductDTO> qRoot) {
		
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (dto.getId() != null && dto.getId() > 0) {
			whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
		}

		if (!isZeroNumber(dto.getQuantity())) {
			whereCondition.add(builder.equal(qRoot.get("quantity"), dto.getQuantity()));
		}

		if (isNotNull(dto.getDelevirydate())) {
			// Assuming "date" field is of type java.util.Date or java.sql.Date
			Date searchDate = dto.getDelevirydate();

			// Define start and end dates for the search day
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(searchDate);
			calendar.set(Calendar.HOUR_OF_DAY, 0); // Start of the day
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			Date startDate = calendar.getTime();

			calendar.set(Calendar.HOUR_OF_DAY, 23); // End of the day
			calendar.set(Calendar.MINUTE, 59);
			calendar.set(Calendar.SECOND, 59);
			Date endDate = calendar.getTime();

			// Create predicate for date range
			Predicate datePredicate = builder.between(qRoot.get("delevirydate"), startDate, endDate);
			whereCondition.add(datePredicate);
		}

		if (!isEmptyString(dto.getBrand())) {

			whereCondition.add(builder.like(qRoot.get("brand"), dto.getBrand() + "%"));
		}
		if (!isZeroNumber(dto.getPrice())) {

			whereCondition.add(builder.equal(qRoot.get("price"), dto.getPrice() ));
		}
		
		if (!isEmptyString(dto.getProductName())) {

			whereCondition.add(builder.like(qRoot.get("productName"), dto.getProductName() + "%"));
		}

		return whereCondition;
	}

	@Override
	public Class<ProductDTO> getDTOClass() {
		
		return ProductDTO.class;
	}

}
