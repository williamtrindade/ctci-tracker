package CTCI77ChatServer;

import java.util.List;

public class Solution {

    public static class ChatServer {
        public int addUser(String name) {
            // TODO: Implement CTCI 7.7 Chat Server
            throw new UnsupportedOperationException("TODO: CTCI 7.7 Chat Server");
        }

        public String getUserName(int userId) {
            throw new UnsupportedOperationException("TODO: CTCI 7.7 Chat Server");
        }

        public void sendFriendRequest(int fromUserId, int toUserId) {
            throw new UnsupportedOperationException("TODO: CTCI 7.7 Chat Server");
        }

        public void approveFriendRequest(int toUserId, int fromUserId) {
            throw new UnsupportedOperationException("TODO: CTCI 7.7 Chat Server");
        }

        public void rejectFriendRequest(int toUserId, int fromUserId) {
            throw new UnsupportedOperationException("TODO: CTCI 7.7 Chat Server");
        }

        public boolean areFriends(int a, int b) {
            throw new UnsupportedOperationException("TODO: CTCI 7.7 Chat Server");
        }

        public List<Integer> pendingRequests(int userId) {
            throw new UnsupportedOperationException("TODO: CTCI 7.7 Chat Server");
        }

        public void setStatus(int userId, UserStatus status) {
            throw new UnsupportedOperationException("TODO: CTCI 7.7 Chat Server");
        }

        public UserStatus getStatus(int userId) {
            throw new UnsupportedOperationException("TODO: CTCI 7.7 Chat Server");
        }

        public int startPrivateChat(int a, int b) {
            throw new UnsupportedOperationException("TODO: CTCI 7.7 Chat Server");
        }

        public int createGroupChat(int creatorId, List<Integer> members) {
            throw new UnsupportedOperationException("TODO: CTCI 7.7 Chat Server");
        }

        public void addToGroup(int chatId, int userId) {
            throw new UnsupportedOperationException("TODO: CTCI 7.7 Chat Server");
        }

        public void sendMessage(int chatId, int senderId, String content) {
            throw new UnsupportedOperationException("TODO: CTCI 7.7 Chat Server");
        }

        public List<Message> getMessages(int chatId) {
            throw new UnsupportedOperationException("TODO: CTCI 7.7 Chat Server");
        }
    }
}
