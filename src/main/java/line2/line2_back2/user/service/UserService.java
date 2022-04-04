package line2.line2_back2.user.service;

import line2.line2_back2.systemMessage.SystemMessage;
import line2.line2_back2.user.model.User;

public interface UserService {
    SystemMessage add(User user);

    SystemMessage edit(User user);

    User findById(Long id);

    SystemMessage deleteById(Long id);
}
