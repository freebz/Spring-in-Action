// 코드 15.3  SimpleJaxWsServiceExporter는 빈을 JAX-WS 엔드포인트로 변환한다.

package com.habuma.spittr.remoting.jaxws;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.habuma.spittr.domain.Spitter;
import com.habuma.spittr.domain.Spittle;
import com.habuma.spittr.service.SpitterService;

@Component
@WebService(serviceName="SpitterService")
public class SpitterServiceEndpoint {

    @Autowired
    SpitterService spitterService;  // SpitterService 오토와이어링

    @WebMethod
    public void addSpittle(Spittle spittle) {
	spitterService.saveSpittle(spittle);  // SpitterService에 위임
    }

    @WebMethod
    public void deleteSpittle(long spittleId) {
	spitterService.deleteSpittle(spittleId);  // SpitterSErvice에 위임
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
