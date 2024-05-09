package AISS.YoutubeMiner.transformation;

import AISS.YoutubeMiner.models.caption.Caption;
import AISS.YoutubeMiner.modelsVideo.CaptionVideo.CaptionVideo;

public class CaptionTransformation {


    public static CaptionVideo transformCaption(Caption cap) {
        return CaptionVideo.of(
                cap.getId(),
                cap.getSnippet().getName(),
                cap.getSnippet().getLanguage()
        );
    }
}
