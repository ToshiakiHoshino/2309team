package com.example.demo.dto;

	/**
	 * ユーザー情報更新リクエストデータ
	 *
	 */
	@Data
	@EqualsAndHashCode(callSuper=false)
	public class ExpenseAdjustmentUpdateRequest extends ExpenseAdjustmentRequest implements Serializable {

	  /**
	   * ユーザーID
	   */
	  @NotNull
	  private Long id;
	}

}
