package spring.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@EqualsAndHashCode
@Setter
@Entity
@Table(name = "tarifas")
public class Tarifa {

	@Id
	private Integer priceList;

	@Column
	private Integer company;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;

	@Column
	private Integer productId;

	@Column
	private Integer priority;

	@Column
	private Double price;
}
