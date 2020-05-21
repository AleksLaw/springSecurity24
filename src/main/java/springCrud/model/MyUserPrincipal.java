package springCrud.model;

public class MyUserPrincipal {
        private User user;

        public MyUserPrincipal(User user) {
            this.user = user;
        }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
