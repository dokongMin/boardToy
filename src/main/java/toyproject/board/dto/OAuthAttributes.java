//package toyproject.board.dto;
//
//import lombok.Builder;
//import lombok.Getter;
//import toyproject.board.domain.Member;
//import toyproject.board.domain.Role;
//
//import java.util.Map;
//
//@Getter
//public class OAuthAttributes {
//
//    private Map<String, Object> attributes;
//    private String nameAttributeKey;
//    private String username;
//    private String email;
//
//    @Builder
//    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String name, String email, String picture) {
//        this.attributes = attributes;
//        this.nameAttributeKey = nameAttributeKey;
//        this.username = username;
//        this.email = email;
//
//    }
//
//
//    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String,Object> attributes) {
//        return OAuthAttributes.builder()
//                .name((String) attributes.get("name"))
//                .email((String) attributes.get("email"))
//                .picture((String) attributes.get("picture"))
//                .attributes(attributes)
//                .nameAttributeKey(userNameAttributeName)
//                .build();
//    }
//
//    private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
//        return OAuthAttributes.builder()
//                .name((String) attributes.get("name"))
//                .email((String) attributes.get("email"))
//                .picture((String) attributes.get("picture"))
//                .attributes(attributes)
//                .nameAttributeKey(userNameAttributeName)
//                .build();
//    }
//
//
//    public Member toEntity() {
//        return Member.builder()
//                .username(username)
//                .email(email)
//                .role(Role.USER)
//                .build();
//    }
//}
