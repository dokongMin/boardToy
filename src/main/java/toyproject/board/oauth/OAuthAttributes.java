package toyproject.board.oauth;//package toyproject.board.oauth;
//
//import lombok.Getter;
//
//import java.util.Map;
//
//@Getter
//public class OAuthAttributes {
//
//    // 생략
//
//    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String,Object> attributes){
//        if("naver".equals(registrationId)) {
//            return ofNaver("id",attributes);
//        }
//        return ofGoogle(userNameAttributeName, attributes);
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
//    private static OAuthAttributes ofNaver(String userNameAttributeName, Map<String, Object> attributes){
//        Map<String, Object> response = (Map<String, Object>) attributes.get("response");
//
//        return OAuthAttributes.builder()
//                .name((String) response.get("name"))
//                .email((String) response.get("email"))
//                .picture((String) response.get("picture"))
//                .attributes(response)
//                .nameAttributeKey(userNameAttributeName)
//                .build();
//    }
//
//    // 생략
//}
