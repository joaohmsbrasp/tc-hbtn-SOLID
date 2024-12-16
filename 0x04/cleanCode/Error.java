public class Error {


    // Use Exceptions ao invés de retornar o código
    //A
    public User createUser(User user){
        try {
            loadUser(user.getId());
            throw new UserExistsException(user.getId())
        }
        catch (UserNotFoundException exception){
            // detail here
        }
        resolveGroup(user);
        return userRepository.save(user);
    }
    //B
    public Object createUser(User user){

        if(loadUser(user.getId()) instanceof User){
            // user already exists
            return USER_ALREADY_EXISTS; // error flag
            return 101; // or error code
        };

        resolveGroup(user);
        return userRepository.save(user);
    }

    // Exceções com contexto    
    //A
    public void validate(String id){
        if(ownerRepo.count(id) == 0){
            throw new ValidationException("ocorreu uma exceção ...")
        }
    }
    // B
    public void validate(String id){
        if(ownerRepo.count(id) == 0){
            throw new ValidationException("id: " + id + " não foi informado, deveria ser informado...")
        }
    }


    // Não retorne nulle não passe null
    //A
    public User createUser(User user){

        if(loadUser(user.getId()) instanceof User){
            // user already exists
            return null;
        };

        resolveGroup(user);
        return userRepository.save(user);
    }
    //B
    public User createUser(User user){

        try {
            loadUser(user.getId());
            throw new UserExistsException(user.getId())
        }
        catch (UserNotFoundException exception){
            // detail here
        }

        resolveGroup(user);
        return userRepository.save(user);
    }

}