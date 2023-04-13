package spring.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TarifaDto {

	private Integer priceList;

	private Integer company;

	private Date startDate;

	private Date endDate;

	private Integer productId;

	private Double price;
}
