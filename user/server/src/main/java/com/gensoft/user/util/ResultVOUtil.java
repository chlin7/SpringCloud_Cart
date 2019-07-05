package com.gensoft.user.util;


import com.gensoft.user.VO.ResultVO;
import com.gensoft.user.enums.ResultEnum;

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

	public static ResultVO success(){
		ResultVO resultVO = new ResultVO<>();
		resultVO.setCode(0);
		resultVO.setMessage("成功");

		return resultVO;
	}

	public static ResultVO error(ResultEnum resultEnum){
		ResultVO resultVO = new ResultVO<>();
		resultVO.setCode(resultEnum.getCode());
		resultVO.setMessage(resultEnum.getMessage());

		return resultVO;
	}
}
