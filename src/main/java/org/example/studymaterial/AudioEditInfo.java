package org.example.studymaterial;

public class AudioEditInfo {
    private AudioReference.AudioQuality audioQuality;
    private boolean isDownloadable;
    private String title;
    private String description;
    private String link;
    private String accessRights;
    private String license;
    private String language;
    private int rating;
    private int viewCount;
    private int shareCount;

    private AudioEditInfo() {
        // private constructor
    }

    public void applyTo(AudioReference audioRef) {
        audioRef.setTitle(title);
        audioRef.setDescription(description);
        audioRef.setLink(link);
        audioRef.setAccessRights(accessRights);
        audioRef.setLicense(license);
        audioRef.setAudioQuality(audioQuality);
        audioRef.setRating(rating);
        audioRef.setShareCount(shareCount);
        audioRef.setViewCount(viewCount);
        audioRef.setDownloadable(isDownloadable);
        audioRef.setLanguage(language);
    }

    public static class Builder {
        private final AudioEditInfo info;

        public Builder() {
            info = new AudioEditInfo();
        }

        public Builder audioQuality(AudioReference.AudioQuality quality) {
            info.audioQuality = quality;
            return this;
        }

        public Builder downloadable(boolean downloadable) {
            info.isDownloadable = downloadable;
            return this;
        }

        public Builder title(String title) {
            info.title = title;
            return this;
        }

        public Builder description(String description) {
            info.description = description;
            return this;
        }

        public Builder link(String link) {
            info.link = link;
            return this;
        }

        public Builder accessRights(String accessRights) {
            info.accessRights = accessRights;
            return this;
        }

        public Builder license(String license) {
            info.license = license;
            return this;
        }

        public Builder language(String language) {
            info.language = language;
            return this;
        }

        public Builder rating(int rating) {
            info.rating = rating;
            return this;
        }

        public Builder viewCount(int viewCount) {
            info.viewCount = viewCount;
            return this;
        }

        public Builder shareCount(int shareCount) {
            info.shareCount = shareCount;
            return this;
        }

        public AudioEditInfo build() {
            return info;
        }
    }
}
