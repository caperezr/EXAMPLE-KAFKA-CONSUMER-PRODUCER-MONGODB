package com.capr.examenlunes.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublishRequest {
    private String userId;
    private String channelId;
}
