package line2.line2_back2.user.controller;

import line2.line2_back2.user.model.User;
import line2.line2_back2.user.model.UserLoginDto;
import line2.line2_back2.systemMessage.SystemMessage;

public interface UserController {
    SystemMessage add(User user);

    SystemMessage edit(User user);

    User findById(Long id);

    SystemMessage deleteById(Long id);

    User login(UserLoginDto userLoginDto);
}
