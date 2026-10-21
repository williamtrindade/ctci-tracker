package CTCI77ChatServer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private Solution.ChatServer server;
    private int ana;
    private int bruno;
    private int carla;

    @BeforeEach
    void setUp() {
        server = new Solution.ChatServer();
        ana = server.addUser("Ana");
        bruno = server.addUser("Bruno");
        carla = server.addUser("Carla");
    }

    @Test
    void usersGetSequentialIds() {
        assertEquals(0, ana);
        assertEquals(1, bruno);
        assertEquals("Carla", server.getUserName(carla));
    }

    @Test
    void friendRequests() {
        server.sendFriendRequest(ana, bruno);
        server.sendFriendRequest(carla, bruno);
        assertEquals(List.of(ana, carla), server.pendingRequests(bruno));
        assertFalse(server.areFriends(ana, bruno));
        server.approveFriendRequest(bruno, ana);
        assertTrue(server.areFriends(ana, bruno));
        assertTrue(server.areFriends(bruno, ana));
        server.rejectFriendRequest(bruno, carla);
        assertFalse(server.areFriends(bruno, carla));
        assertTrue(server.pendingRequests(bruno).isEmpty());
        assertThrows(IllegalStateException.class, () -> server.approveFriendRequest(bruno, carla));
    }

    @Test
    void status() {
        assertEquals(UserStatus.OFFLINE, server.getStatus(ana));
        server.setStatus(ana, UserStatus.BUSY);
        assertEquals(UserStatus.BUSY, server.getStatus(ana));
    }

    @Test
    void privateChatOnlyBetweenFriends() {
        assertThrows(IllegalStateException.class, () -> server.startPrivateChat(ana, bruno));
        server.sendFriendRequest(ana, bruno);
        server.approveFriendRequest(bruno, ana);
        int chat = server.startPrivateChat(ana, bruno);
        assertEquals(chat, server.startPrivateChat(bruno, ana), "Deve reutilizar a conversa existente");
        server.sendMessage(chat, ana, "Oi!");
        server.sendMessage(chat, bruno, "Olá");
        assertEquals(List.of(new Message(ana, "Oi!"), new Message(bruno, "Olá")), server.getMessages(chat));
        assertThrows(IllegalStateException.class, () -> server.sendMessage(chat, carla, "intrusa"));
    }

    @Test
    void groupChats() {
        int group = server.createGroupChat(ana, List.of(bruno));
        server.sendMessage(group, bruno, "bem-vindos");
        assertThrows(IllegalStateException.class, () -> server.sendMessage(group, carla, "oi"));
        server.addToGroup(group, carla);
        server.sendMessage(group, carla, "oi");
        assertEquals(2, server.getMessages(group).size());
    }
}
