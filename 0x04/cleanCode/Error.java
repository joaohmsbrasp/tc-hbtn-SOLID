public class Error {

    // Use Exceptions ao invés de retornar o código
    public User createUser(User user) {
        try {
            loadUser(user.getId());
            throw new UserExistsException(user.getId());
        } catch (UserNotFoundException exception) {
            // detail here
        }
        resolveGroup(user);
        return userRepository.save(user);
    }

    // Exceções com contexto
    public void validate(String id) {
        if (ownerRepo.count(id) == 0) {
            throw new ValidationException("id: " + id + " não foi informado, deveria ser informado...");
        }
    }

    // Não retorne null e não passe null
    public User createUserHandlingNull(User user) {
        try {
            loadUser(user.getId());
            throw new UserExistsException(user.getId());
        } catch (UserNotFoundException exception) {
            // detail here
        }

        resolveGroup(user);
        return userRepository.save(user);
    }
}
