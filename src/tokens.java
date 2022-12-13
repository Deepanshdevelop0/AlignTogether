import io.jsonwebtoken.*;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;

public class tokens {

        public static void jwt(String[] parts) {
//        JSONParser parser = new J
            String part = parts[1];
            byte[] bytes = Base64.getUrlDecoder().decode(part);
            String decoded = new String(bytes, StandardCharsets.UTF_8);

//            System.out.println(bytes[0]);
            try{
                Jwts.parser().setSigningKey(parts[2]).parseClaimsJws(parts[1]);
                System.out.println("success");
            }
            catch(ExpiredJwtException exJwt){
                exJwt.getMessage();
            }

//            JsonObject payload = new JsonObject(decode());
//            JSONParser payload = new JsonObject();

//                byte[] bytes ;
//            String decoded= Arrays.toString(Base64.getUrlDecoder().decode(token));
//                String decoded = new String(Base64.getUrlDecoder().decode(parts));
//                String token1 = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";
//
//                DecodedJWT jwt = JWT.decode(token1);


//            System.out.println("Decoded: " + decoded);


            System.out.println(decoded);

//        String decoded = new String(Base64.getUrlDecoder().decode(parts));

        }

    public static Jws<Claims> parseJwt(String jwtString) {
        String secret = "asdfSFS34wfsdfsdfSDSD32dfsddDDerQSNCK34SOWEK5354fdgdf4";
        Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secret),
                SignatureAlgorithm.HS256.getJcaName());

        Jws<Claims> jwt = Jwts.parserBuilder()
                .setSigningKey(hmacKey)
                .build()
                .parseClaimsJws(jwtString);

        return jwt;
    }


    public static void main(String args[]) {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";
        String[] parts = token.split("\\.");
        jwt(parts);
        Jws samle = parseJwt(token);
        System.out.println();
    }

}

