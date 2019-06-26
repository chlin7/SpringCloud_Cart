package com.gensoft.order.util;

import com.gensoft.order.VO.ResultVO;

/**
 * @ desc：
 * @ Author     ：chenhl01.
 * @ Date       ：Created in 14:39 2019/6/10
 */
public class ResultVOUtil {

	public static ResultVO success(Object obj){
		ResultVO resultVO = new ResultVO<>();
		resultVO.setData(obj);
		resultVO.setCode(0);
		resultVO.setMessage("成功");

		return resultVO;
	}
}
