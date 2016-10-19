// 코드 20.1  MBean이 되기 위해 SpittleController에 애너테이션 적용하기

package com.habuma.spittr.mvc;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.habuma.spittr.service.SpittrService;

@Controller
@ManagedResource(objectName="spitter:name=SpittleController")  // MBean으로 SpittleController 익스포트하기
public class SpittleController {

    @ManagedAttribute  // 관리 애트리뷰트로 spittlesPerPage 노출하기
    public void setSpittlesPerPage(int spittlesPerPage) {
	this.spittlesPerPage = spittlesPerPage;
    }

    @ManagedAttribute
    public int getSpittlesPerPage() {
	return spittlesPerPage;
    }
}
