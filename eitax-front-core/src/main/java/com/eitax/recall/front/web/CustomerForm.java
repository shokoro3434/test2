package com.eitax.recall.front.web;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CustomerForm {
	@NotNull
	@Size(min = 1, max = 127)
	private String firstName;
	@NotNull
	@Size(min = 1, max = 127)
	private String lastName;
	private String fselect;
	private String[] fmselect;
	private String triggerItemId;
	private String[] toriggerItems;
	@Size(min = 1, max = 127)
	private String freeText;
	private boolean admin;
}
