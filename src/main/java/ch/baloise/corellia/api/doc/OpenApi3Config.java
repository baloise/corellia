package ch.baloise.corellia.api.doc;

import java.util.Arrays;

public class OpenApi3Config {

    private String[] resourcePackages;
    private boolean prettyPrint;
    private int cacheTTL;
    private OpenApiInfoWrapper openAPI;



    public String[] getResourcePackages() {
        return resourcePackages;
    }

    public void setResourcePackages(String[] resourcePackages) {
        this.resourcePackages = resourcePackages;
    }

    public boolean isPrettyPrint() {
        return prettyPrint;
    }

    public void setPrettyPrint(boolean prettyPrint) {
        this.prettyPrint = prettyPrint;
    }

    public int getCacheTTL() {
        return cacheTTL;
    }

    public void setCacheTTL(int cacheTTL) {
        this.cacheTTL = cacheTTL;
    }

    public OpenApiInfoWrapper getOpenAPI() {
        return openAPI;
    }

    public void setOpenAPI(OpenApiInfoWrapper openAPI) {
        this.openAPI = openAPI;
    }

    @Override
    public String toString() {
        return String.format("OpenApi3Config{resourcePackages='%s', prettyPrint='%b', cacheTTL='%d', openAPI='%s'}", Arrays.toString(resourcePackages), prettyPrint, cacheTTL, openAPI);
    }

    public static class OpenApiInfoWrapper {
        private OpenApiInfo info;

        public OpenApiInfo getInfo() {
            return info;
        }

        public void setInfo(OpenApiInfo info) {
            this.info = info;
        }

        @Override
        public String toString() {
            return String.format("OpenApiInfoWrapper{info='%s'}", info);
        }
    }

    public static class OpenApiInfo {
        private String version;
        private String title;
        private String description;
        private Contact contact;
        private License license;

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Contact getContact() {
            return contact;
        }

        public void setContact(Contact contact) {
            this.contact = contact;
        }

        public License getLicense() {
            return license;
        }

        public void setLicense(License license) {
            this.license = license;
        }

        @Override
        public String toString() {
            return String.format("OpenApiInfo{version='%s', title='%s', description='%s', contact='%s', license='%s'}", version, title, description, contact, license);
        }
    }


    public static class Contact {
        private String email;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public String toString() {
            return String.format("Contact{email='%s'}", email);
        }
    }

    public static class License {
        private String name;
        private String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return String.format("License{name='%s', url='%s'}", name, url);
        }
    }

}
