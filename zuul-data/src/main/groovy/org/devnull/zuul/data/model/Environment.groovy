package org.devnull.zuul.data.model

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.devnull.zuul.data.config.ZuulDataConstants
import org.hibernate.annotations.Cache
import org.hibernate.annotations.CacheConcurrencyStrategy

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
@EqualsAndHashCode(includes = "name")
@ToString(includeNames = true, excludes = "groups")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
class Environment implements Serializable {

    static final long serialVersionUID = ZuulDataConstants.API_VERSION

    @Id
    String name


    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "environment")
    List<SettingsGroup> groups = []


}
