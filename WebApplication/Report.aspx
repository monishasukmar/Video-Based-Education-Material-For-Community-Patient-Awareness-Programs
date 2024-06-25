<%@ Page Title="" Language="vb" AutoEventWireup="false" MasterPageFile="~/Site2.Master" CodeBehind="Report.aspx.vb" Inherits="WebApplication1.WebForm10" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="conMain" runat="server">
    <h2>Report</h2>
    <center>
        <asp:Table Width="90%" ID="Table1" runat="server" GridLines="Both">
            <asp:TableRow runat="server">
                <asp:TableCell CssClass="th1" runat="server">SNo</asp:TableCell>
                <asp:TableCell CssClass="th1" runat="server">Date Time</asp:TableCell>
                <asp:TableCell CssClass="th1" runat="server">No of Patients</asp:TableCell>
                <asp:TableCell CssClass="th1" runat="server">Avg Pre Score</asp:TableCell>
                <asp:TableCell CssClass="th1" runat="server">Avg Post Score</asp:TableCell>
                <asp:TableCell CssClass="th1" runat="server">View Patients</asp:TableCell>
            </asp:TableRow>

        </asp:Table>
    </center>
</asp:Content>
<asp:Content ID="Content4" ContentPlaceHolderID="ContentPlaceHoldelast" runat="server">
</asp:Content>
