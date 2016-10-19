// 코드 5.18  SpittleForm: SpittlePost 요청에서 제출된 필드만 전달하기

package spittr;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Spitter {

    private Long id;

    @NotNull
    @Size(min=5, max=16)  // null이 아니며 길이가 5에서 16인 문자열
    private String username;

    @NotNull
    @Size(min=5, max=25)  // null이 아니며 길이가 5에서 25인 문자열
    private String password;

    @NotNull
    @Size(min=2, max=30)  // null이 아니며 길이가 2에서 30인 문자열
    private String firstName;

    @NotNull
    @Size(min=2, max=30)  // null이 아니며 길이가 2에서 30인 문자열
    private String lastName;

    ...
}
