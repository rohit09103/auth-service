/**
 * 
 */
package com.localhost.auth.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseErrorResponse {
	
	private String errorCode;
	private String errorMessage;
	
}
