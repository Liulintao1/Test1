package com.llt.daoImpl;


import org.springframework.stereotype.Service;

import com.llt.dao.FrigBiz;
import com.llt.util.NoThisFrigException;
@Service("frigBiz")
public class BuyFrigBizImpl implements FrigBiz {
	public void buyFrig(String customer, String frig) throws NoThisFrigException {		
       if ("美的".equals(frig)) {
		throw new NoThisFrigException("对不起，没有"+frig+"的货了");
	}
       System.out.println("您好！您已经购买了一台"+frig);
	}

}
