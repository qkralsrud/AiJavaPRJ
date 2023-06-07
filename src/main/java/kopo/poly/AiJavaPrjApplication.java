package kopo.poly;

import kopo.poly.dto.StudentDTO;
import kopo.poly.service.INlpService;
import kopo.poly.service.IOcrService;
import kopo.poly.service.IStudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
public class AiJavaPrjApplication implements CommandLineRunner {

    private final IOcrService ocrService; //이미지 인식

    private final INlpService nlpService; //자연어 처리

    private final IStudentService studentService;
    public static void main(String[] args) {
        SpringApplication.run(AiJavaPrjApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("자바 프로그래밍 시작!");

//        String filePath = "image";
//        String fileName = "sample01.jpg";
//
//        OcrDTO pDTO = new OcrDTO();
//
//        pDTO.setFilePath(filePath);
//        pDTO.setFileName(fileName);
//
//        OcrDTO rDTO = ocrService.getReadforImageText(pDTO);
//
//        String result = rDTO.getResult();
//
//        log.info("인식된 문자열");
//        log.info(result);
//
//        NlpDTO nlpDTO =nlpService.getPlainText(result);
//        log.info("형태소별 품사 분석 결과 : " + nlpDTO.getResult());
//
//        nlpDTO = nlpService.getNouns(result);
//        List<String> nouns = nlpDTO.getNouns();
//
//        Set<String> distinct = new HashSet<>(nouns);
//
//        log.info("중복 제거 수행 전 단어 수 : " + nouns.size());
//        log.info("중복 제거 수행 후 단어 수 : " + distinct.size());
//
//        Map<String, Integer> rMap = new HashMap<>();
//
//        for (String s : distinct){
//            int count = Collections.frequency(nouns, s);
//            rMap.put(s, count);
//
//            log.info(s, count);
//        }
//        List<Map.Entry<String, Integer>> sortResult = new LinkedList<>(rMap.entrySet());
//
//        Collections.sort(sortResult, ((o1, o2) -> o2.getValue().compareTo(o1.getValue())));
//
//        log.info("가장 많이 사용된 단어는? : " + sortResult);
        StudentDTO pDTO;
        List<StudentDTO> rList;
        
        pDTO = new StudentDTO();
        
        pDTO.setUserId("hglee67");
        pDTO.setUserName("이협건");
        pDTO.setEmail("hglee67@kopo.ac.kr");
        pDTO.setAddr("서울");
        
        rList = studentService.insertStudent(pDTO);
        
        rList.forEach(dto -> {
            log.info("DB에 저장된 아이디 : " + dto.getUserId());
            log.info("DB에 저장된 이름 : " + dto.getUserName());
            log.info("DB에 저장된 이메일 : " + dto.getEmail());
            log.info("DB에 저장된 주소 : " + dto.getAddr());
        });
        log.info("자바 프로그래밍 종료!");
    }
}
