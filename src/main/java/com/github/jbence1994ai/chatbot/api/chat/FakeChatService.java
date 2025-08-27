package com.github.jbence1994ai.chatbot.api.chat;

import org.springframework.stereotype.Service;

@Service
public class FakeChatService implements ChatService {

    public Chat chat(String prompt) {
        return new Chat("""
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed euismod, nunc at facilisis fermentum,
                elit libero pretium turpis, vitae tincidunt est purus nec lorem. Suspendisse potenti.
                Nullam quis risus nec tortor posuere ullamcorper. Fusce viverra, est ut ullamcorper varius,
                metus nisi finibus erat, a tincidunt mauris ipsum nec lorem. Vestibulum ante ipsum primis in
                faucibus orci luctus et ultrices posuere cubilia curae; Integer in arcu ut mi suscipit vehicula.
                Curabitur euismod magna nec turpis malesuada, vel vestibulum mauris egestas.
                """
        );
    }
}
