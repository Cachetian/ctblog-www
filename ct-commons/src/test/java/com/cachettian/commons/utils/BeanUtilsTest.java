package com.cachettian.commons.utils;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.cachetian.commons.utils.BeanUtils;
import com.cachettian.commons.utils.test.UserBo;
import com.cachettian.commons.utils.test.UserVo;

public class BeanUtilsTest {

	@Test
	public void testCopyProperties() {
		// test copy value
		UserBo bo = new UserBo();
		UserVo vo = new UserVo();
		bo.setId(1L);
		bo.setUniqueName("user01");
		BeanUtils.copyProperties(bo, vo, Arrays.asList(new String[] {"Id", "UniqueName" }));
		Assert.assertEquals(vo.getUniqueName(), bo.getUniqueName());
		Assert.assertEquals(vo.getId(), bo.getId());
	}
}
