import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.Set;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import org.json.JSONException;
import org.json.JSONObject;

import static java.lang.Long.decode;


public class tokens {

        public static void jwt(String[] parts) {
//        JSONParser parser = new J
            String part = parts[1];
            byte[] bytes = Base64.getUrlDecoder().decode(part);

            String decoded = new String(bytes, StandardCharsets.UTF_8);



            byte[] secretKey = Base64.getUrlDecoder().decode(parts[2]);
            String decoded1 = new String(secretKey, StandardCharsets.UTF_8);
//            System.out.println(decoded1);

            JSONObject jsonObject = new JSONObject(decoded);
            System.out.println(jsonObject);
            try{
            if(jsonObject.getLong("exp") > (System.currentTimeMillis() / 1000))
                System.out.println(true);
            else
                System.out.println(false);
            }
            catch (JSONException je){
                System.out.println(false);
            }

//            System.out.println(decoded);

        }

//    private Date getExpiredDateFromToken(String token) {
//        String claims = Claims.getClaimsFromToken(token);
//        return claims.getExpiration();
//    }
//
//    private static String getClaimsFromToken(String token) {
//        String expiration = Claims.EXPIRATION;
//        return Claims.EXPIRATION;
//
//    }
//    public static Exception getExpirationDateFromToken(String token) {
//        try {
//            Claims claims = parseJWT(token);
//            if (claims.getExpiration().getTime() <= System.currentTimeMillis()) {
//                return getClaimsFromToken(token).getExpiration();
//            }
//        }
//        catch (Exception ex){
//            return ex;
//        }
//        return null;
//    }



//    public static Jws<Claims> parseJwt(String jwtString) {
//        String secret = "asdfSFS34wfsdfsdfSDSD32dfsddDDerQSNCK34SOWEK5354fdgdf4";
//        Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secret),
//                SignatureAlgorithm.HS256.getJcaName());
//
//        Jws<Claims> jwt = Jwts.parserBuilder()
//                .setSigningKey(hmacKey)
//                .build()
//                .parseClaimsJws(jwtString);
//
//        return jwt;
//
//    }


            public static void main (String args[]){
                String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";
                String[] parts = token.split("\\.");
                jwt(parts);
            }

        }