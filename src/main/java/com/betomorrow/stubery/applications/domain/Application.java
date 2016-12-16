package com.betomorrow.stubery.applications.domain;

import org.springframework.data.annotation.Id;

public class Application {

    @Id
    private String id;

    private String name;
    private String contextPath;
    private String icon;

    public Application() {
    }

    public Application(String id, String name, String contextPath, String icon) {
        this.id = id;
        this.name = name;
        this.contextPath = contextPath;
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void updateWith(Application data) {
        contextPath = data.getContextPath();
        name = data.getName();
        icon = data.getIcon();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Application that = (Application) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (contextPath != null ? !contextPath.equals(that.contextPath) : that.contextPath != null) return false;
        return icon != null ? icon.equals(that.icon) : that.icon == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (contextPath != null ? contextPath.hashCode() : 0);
        result = 31 * result + (icon != null ? icon.hashCode() : 0);
        return result;
    }
}
