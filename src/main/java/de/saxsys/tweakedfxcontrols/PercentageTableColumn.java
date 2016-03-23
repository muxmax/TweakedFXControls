package de.saxsys.tweakedfxcontrols;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.control.TableColumn;


/**
 * Other UI components as for instance GridView provide the ability to set the width as a percentage. That is the
 * GridView then tries to reach the width of a GridViewColumn of the given percentage.
 * <p>
 * Exactly that behavior I'm missing at JavaFX TableColumns. When I want to get the dynamic with by percentage, I have
 * to define Bindings for each Column. That can be a lot of boilerplate code, especially in applications having many
 * tables.
 * <p>
 * I want a table column, that takes a percentage value and then resizes its width to match that percentage.
 * <p>
 * An extension of the {@link TableColumn} that adds custom resizing behavior für percentage width of the column.
 */
public class PercentageTableColumn extends TableColumn {

    private DoubleProperty percentageWidth = new SimpleDoubleProperty();

    public PercentageTableColumn() {
        // The table property is set delayed each column by column
        tableViewProperty().addListener((observable, oldValue, newValue) -> {
            ReadOnlyDoubleProperty tableWidth = getTableView().widthProperty();
            this.prefWidthProperty().bind(createPercentageWidthBinding(tableWidth));
        });
    }

    private DoubleBinding createPercentageWidthBinding(ReadOnlyDoubleProperty tableWidth) {
        return Bindings.createDoubleBinding(
                () -> {
                    // If the user doesn't define the percentage
                    if (percentageWidth.get() <= 0) {
                        return getWidth();
                    } else {
                        double tableWidthDouble = tableWidth.get();
                        if (percantageValueIsOverHundred()) {

                        }
                        return percentageWidth.get() * tableWidthDouble / 100;
                    }
                }, percentageWidth, tableWidth);
    }

    private boolean percantageValueIsOverHundred() {

        this.getTableView().getColumns().stream().mapToDouble(
                value -> ((PercentageTableColumn) value).getPercentageWidth()).sum();

        return false;
    }

    public double getPercentageWidth() {
        return percentageWidth.get();
    }

    public DoubleProperty percentageWidthProperty() {
        return percentageWidth;
    }

    public void setPercentageWidth(double percentageWidth) {
        this.percentageWidth.set(percentageWidth);
    }
}