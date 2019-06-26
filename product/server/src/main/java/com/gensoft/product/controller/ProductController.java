package com.gensoft.product.controller;

import com.gensoft.product.VO.ProductInfoVO;
import com.gensoft.product.VO.ProductVO;
import com.gensoft.product.VO.ResultVO;
import com.gensoft.product.dto.CartDTO;
import com.gensoft.product.entity.ProductCategory;
import com.gensoft.product.entity.ProductInfo;
import com.gensoft.product.service.IProductCategoryService;
import com.gensoft.product.service.IProductService;
import com.gensoft.product.util.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ desc：
 * @ Author     ：chenhl01.
 * @ Date       ：Created in 14:35 2019/6/6
 */
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private IProductService productService;

	@Autowired
	private IProductCategoryService productCategoryService;

	/**
	 * 1.0 查询所有在架的商品
	 * 2.0 查询类目type列表
	 * 3.0 查询类目
	 * 4.0 构造数据
	 * @return
	 */
	@GetMapping("/list")
	public ResultVO<ProductVO> list(){

		List<ProductInfo> productInfoList = productService.findUpAll();

		List<Integer> categoryTypeList = productInfoList.stream().map(ProductInfo::getCategoryType).collect(Collectors.toList());

		List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(categoryTypeList);

		List<ProductVO> productVOList = new ArrayList<>();

		for (ProductCategory productCategory : productCategoryList) {
			ProductVO productVO = new ProductVO();
			List<ProductInfoVO> productInfoVOList = new ArrayList<>();
			for (ProductInfo productInfo:productInfoList) {
				if (productInfo.getCategoryType().equals(productCategory.getCategoryId())){
					ProductInfoVO productInfoVO = new ProductInfoVO();
					BeanUtils.copyProperties(productInfo,productInfoVO);
					productInfoVOList.add(productInfoVO);
				}
			}

			productVO.setProductInfoVOS(productInfoVOList);
			productVOList.add(productVO);
		}

		return ResultVOUtil.success(productVOList);
	}

	@PostMapping("/listForOrder")
	public List<ProductInfo> listForOrder(@RequestBody List<String> productList){
		return productService.findList(productList);
	}

	@PostMapping("/decreaseStock")
	public void decreaseStock(@RequestBody List<CartDTO> cartDTOList){
		productService.decreaseStock(cartDTOList);
	}
}
