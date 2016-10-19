// 코드 15.1  SpitterService: SpitterService는 Spittr 애플리케이션의 서비스 계층을 정의한다.

package com.habuma.spittr.service;
import java.util.List;
import com.habuma.spittr.domain.Spitter;
import com.habuma.spittr.domain.Spittle;
public interface SpitterService {
    List<Spittle> getRecentSpittles(int count);
    void saveSpittle(Spittle spittle);
    void saveSpitter(Spitter spitter);
    Spitter getSpitter(long id);
    void startFollowing(Spitter follower, Spitter follwee);
    List<Spittle> getSpittlesForSpitter(Spitter spitter);
    List<Spittle> getSpittlesForSpitter(String username);
    Spitter getSpitter(String username);
    Spittle getSpittleById(long id);
    void deleteSpittle(long id);
    List<Spitter> getAllSpitters();
}
