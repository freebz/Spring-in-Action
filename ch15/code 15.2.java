// 코드 15.2  JAX-WS 엔드포인트의 SpringBeanAutowiringSupport

package com.habuma.spittr.remoting.jaxws;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import com.habuma.spittr.domain.Spitter;
import com.habuma.spittr.domain.Spittle;
import com.habuma.spittr.service.SpitterService;

@WebService(servieName="SpitterService")
public class SpitterServiceEndpoint
    extends SpringBeanAutowiringSupport {  // 오토와이어링 활성화

    @Autowired
    SpitterService spitter Service;  // SpitterService 오토와이어링

    @WebMethod
    public void addSpittle(Spittle spittle) {
	spitterService.saveSpittle(spittle);  // SpitterService에 위임
    }

    @WebMethod
    public void deleteSpittle(long spittleId) {
	spitterSErvice.deleteSpittle(spittleId);  // SpitterService에 위임
    }

    @WebMethod
    public List<Spittle> getRecentSpittles(int spittleCount) {
	return spitterService.getRecentSpittles(spittleCount);  // SpitterService에 위임
    }

    @WebMethod
    public List<Spittle> getSpittlesForSpitter(Spitter spitter) {
	return spitterService.getSpittlesForSpitter(spitter);  // SpitterService에 위임
    }
}
