package com.krystal.bull.core.gui

import akka.actor.ActorSystem
import com.krystal.bull.core.KrystalBullAppConfig
import com.krystal.bull.core.gui.settings.Themes
import org.bitcoins.core.config._
import scalafx.beans.property.StringProperty

import scala.concurrent.ExecutionContextExecutor

object GlobalData {

  implicit val system: ActorSystem = ActorSystem("krystal-bull")
  implicit val ec: ExecutionContextExecutor = system.dispatcher

  val appConfig: KrystalBullAppConfig =
    KrystalBullAppConfig.fromDefaultDatadir()

  val log: StringProperty = StringProperty("")

  val statusText: StringProperty = StringProperty("")

  var darkThemeEnabled: Boolean = true

  def currentStyleSheets: Seq[String] =
    if (GlobalData.darkThemeEnabled) {
      Seq(Themes.DarkTheme.fileLocation)
    } else {
      Seq.empty
    }

  var network: BitcoinNetwork = MainNet
}
