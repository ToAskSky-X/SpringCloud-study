package gosker.service;

import org.springframework.web.client.RestTemplate;

public class RestTemplateTest {


    public void testGet(){
        RestTemplate restTemplate = new RestTemplate();
        //restTemplate.getForObject(restTemplate.getForEntity());

    }

    public static void main(String[] args) {
       /* for (int i = 0; i <=6 ; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH)-i);
            Date time = calendar.getTime();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String format = simpleDateFormat.format(time);
            System.out.println(format);
        }*/
        Integer s = 45;
        System.out.println(s.toString());

    }
}
