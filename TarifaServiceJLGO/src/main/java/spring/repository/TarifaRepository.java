package spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.entity.Tarifa;

public interface TarifaRepository extends JpaRepository<Tarifa, Integer> {

	public List<Tarifa> findByEndDateGreaterThanEqualAndCompanyAndProductId(Date fecha, Integer company, Integer productId);

	public List<Tarifa> findByStartDateLessThanEqualAndCompanyAndProductId(Date fecha, Integer company, Integer productId);
}
