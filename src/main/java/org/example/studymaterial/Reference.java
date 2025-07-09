package org.example.studymaterial;

public abstract class Reference {
    private String title;
    private String description;
    private String link;
    private String accessRights;
    private String license;
    private boolean isDownloadable;
    private int rating;
    private String language;
    private int viewCount;
    private int downloadCount;
    private int shareCount;

    protected Reference(String title, String description, String link, String accessRights,
                        String license, boolean isDownloadable, String language) {
        this.title = title;
        this.description = description;
        this.link = link;
        this.accessRights = accessRights;
        this.license = license;
        this.isDownloadable = isDownloadable;
        this.language = language;
    }

    protected Reference() {
        this(null, null, null, null, null, false, null);
    }

    // === Getters only (no public setters) ===

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLink() {
        return link;
    }

    public String getAccessRights() {
        return accessRights;
    }

    public String getLicense() {
        return license;
    }

    public boolean isDownloadable() {
        return isDownloadable;
    }

    public boolean getIsDownloadable() {
        return isDownloadable();
    }

    public String getLanguage() {
        return language;
    }

    public int getRating() {
        return rating;
    }

    public int getViewCount() {
        return viewCount;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public int getShareCount() {
        return shareCount;
    }

    // === Controlled mutability (protected or internal methods only) ===

    protected void setTitle(String title) {
        this.title = title;
    }

    protected void setDescription(String description) {
        this.description = description;
    }

    protected void setLink(String link) {
        this.link = link;
    }

    protected void setAccessRights(String accessRights) {
        this.accessRights = accessRights;
    }

    protected void setLicense(String license) {
        this.license = license;
    }

    protected void setDownloadable(boolean downloadable) {
        this.isDownloadable = downloadable;
    }

    protected void setLanguage(String language) {
        this.language = language;
    }

    protected void setRating(int rating) {
        this.rating = rating;
    }

    protected void setViewCount(int viewCount) {
        this.viewCount = Math.max(viewCount, 0);
    }

    protected void setDownloadCount(int downloadCount) {
        this.downloadCount = Math.max(downloadCount, 0);
    }

    protected void setShareCount(int shareCount) {
        this.shareCount = Math.max(shareCount, 0);
    }

    // === Behavioral Logic ===

    public void registerView() {
        viewCount++;
    }

    public void registerDownload() {
        if (isDownloadable) {
            downloadCount++;
        }
    }

    public void registerShare() {
        shareCount++;
    }

    public double getPopularityScore() {
        return viewCount * 0.2 + downloadCount * 0.5 + shareCount * 0.3;
    }

    public boolean isPopularAndDownloadable() {
        return isDownloadable && getPopularityScore() > 50;
    }

    public boolean hasValidMetadata() {
        return title != null && description != null && link != null && license != null;
    }
}
