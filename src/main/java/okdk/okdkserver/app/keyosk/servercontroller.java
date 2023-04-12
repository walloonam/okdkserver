package okdk.okdkserver.app.keyosk;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class servercontroller {

    @PostMapping(value = "/server/image",consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public String saveImage(@RequestParam MultipartFile imgFile) throws IOException {
        System.out.println(imgFile);
        if(!imgFile.isEmpty()){
            String fullPath = "C:/okdkserver/image/" + imgFile.getOriginalFilename();
            System.out.println("파일 저장 full path = "+ fullPath);
            imgFile.transferTo(new File(fullPath));
        }
        return "test-form";
    }

    @PostMapping(value = "/arduino/json")
    public void arduninoSignal(@RequestBody arduinoRequest ArduinoRequest){
        System.out.println(ArduinoRequest.resultvalue);
    }
}
