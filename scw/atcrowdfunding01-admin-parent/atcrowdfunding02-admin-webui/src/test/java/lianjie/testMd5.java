package lianjie;

import org.junit.Test;

import com.atguigu.crowd.utils.CrowdUtil;

public class testMd5 {
	@Test
	public void testMd5() {
		String resource="123123";
		String md5 = CrowdUtil.md5(resource);
		System.out.println(md5);
	}

}
