package ir.maktab.homeserviceprovider.controller.user;

import ir.maktab.homeserviceprovider.dto.user.ExpertDto;
import ir.maktab.homeserviceprovider.exception.DataNotExistsException;
import ir.maktab.homeserviceprovider.service.user.ExpertService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/experts")
@RequiredArgsConstructor
public class ExpertController implements IUserController<ExpertDto> {

    private final ExpertService service;

    @Override
    public ResponseEntity<ExpertDto> signUp(ExpertDto registerDto) {
        Optional<ExpertDto> optSaved = service.save(registerDto);
        return optSaved.map(dto -> ResponseEntity.status(HttpStatus.CREATED).body(dto))
                .orElse(null);
    }

    @Override
    public ResponseEntity<ExpertDto> getProfile(Long id) {
        Optional<ExpertDto> optLoaded = this.service.load(id);
        return optLoaded.map(ResponseEntity::ok)
                .orElse(null);
    }

    @Override
    public ResponseEntity<ExpertDto> updateProfile(Long id, ExpertDto dto) {
        dto.setId(id);
        Optional<ExpertDto> optUpdated = this.service.update(dto);
        return optUpdated.map(ResponseEntity::ok)
                .orElse(null);
    }

    @Override
    public ResponseEntity<String> changePassword(Long id, String newPassword) {
        try {
            service.updatePasswordById(id, newPassword);
            return ResponseEntity.ok("Expert password changed successfully");
        } catch (DataNotExistsException e) {
            return ResponseEntity.ok("Expert with id:" + id + " does not exist");
        }
    }

    @Override
    public ResponseEntity<String> deleteAccount(Long id) {
        try {
            this.service.deleteById(id);
            return ResponseEntity.ok("Expert account has been successfully deleted");
        } catch (DataNotExistsException e) {
            return ResponseEntity.ok("Expert with id:" + id + " does not exist");
        }
    }
}
